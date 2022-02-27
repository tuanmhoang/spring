package com.tuanmhoang.spring.xml.data;

import com.google.gson.Gson;
import com.tuanmhoang.spring.xml.entities.UserEntity;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.util.ResourceUtils;

@Getter
@Setter
@Slf4j
public class UserDataService {

    private Map<Long, UserEntity> userData = new HashMap<>();

    public void init() throws FileNotFoundException {
        File fileData = ResourceUtils.getFile("classpath:data/user.json");

        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(fileData)) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            Gson gson = new Gson();
            UserEntity[] userEntities = gson.fromJson(obj.toString(), UserEntity[].class);
            for ( UserEntity userEntity: userEntities ) {
                userData.put(userEntity.getId(), createUserData(
                    userEntity.getId(),
                    userEntity.getName(),
                    userEntity.getEmail()));
            }

        } catch (FileNotFoundException e) {
            log.error(">>> Exception: {} ", e);
        } catch (IOException e) {
            log.error(">>> Exception: {} ", e);
        } catch (ParseException e) {
            log.error(">>> Exception: {} ", e);
        }
    }

    private UserEntity createUserData(long id, String name, String email) {
        return new UserEntity(id, name, email);
    }

}
