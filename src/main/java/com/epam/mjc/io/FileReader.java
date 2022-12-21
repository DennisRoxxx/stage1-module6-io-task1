package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Map<String, String> profileInfo = new HashMap<>(4);
        Profile profile = new Profile();
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file))) {
            for (int i = 1; i <= 4; i++) {
                String[] keyWord = bufferedReader.readLine().split(": ");
                profileInfo.put(keyWord[0], keyWord[1]);
            }
            profile.setName(profileInfo.get("Name"));
            profile.setAge(Integer.parseInt(profileInfo.get("Age")));
            profile.setEmail(profileInfo.get("Email"));
            profile.setPhone(Long.parseLong(profileInfo.get("Phone")));
            return profile;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return profile;
    }
}
