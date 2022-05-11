package com.example.runcmd;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
@Controller
public class runCmd {
    @ResponseBody
    @RequestMapping("/runCmd")
    public String run(@RequestParam("cmdStr") String cmdStr){
        Process process;
        StringBuilder returnStr = new StringBuilder();
        int exitValue = -1;
        try {
            process = Runtime.getRuntime().exec(cmdStr);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while((line = bufferedReader.readLine()) != null) {
                returnStr.append(line);
            }
            exitValue = process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println("returnStr:" + returnStr);
        return returnStr + "\n执行结果:" + exitValue;
    }
}
