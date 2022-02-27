package com.tuanmhoang.spring.xml.data;

import com.google.gson.Gson;
import com.tuanmhoang.spring.xml.entities.UserEntity;
import com.tuanmhoang.spring.xml.model.User;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.util.ResourceUtils;

@Getter
@Setter
public class UserData {

    private Map<Long, UserEntity> userData = new HashMap<>();

    public void init() throws FileNotFoundException {
        File fileData = ResourceUtils.getFile("classpath:data/user.json");

        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(fileData)) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            //final String s1 = obj.toString();
            //JSONArray users = (JSONArray)obj;
            //System.out.println(users);
            //final String s = users.toJSONString();
            //final Object o = users.get(1);
            Gson gson = new Gson();
            UserEntity[] users = gson.fromJson(obj.toString(), UserEntity[].class);

System.out.println("hello");
            //Iterate over employee array
//            users.forEach(u->userData.put( ));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        userData.put(1L, createUserData(1L, "Alice", "alice@email.com"));
        userData.put(1L, createUserData(2L, "Bob", "bob@email.com"));
        userData.put(1L, createUserData(3L, "Cindy", "cindy@email.com"));
        userData.put(1L, createUserData(4L, "Danny", "danny@email.com"));
        userData.put(1L, createUserData(5L, "Edgar", "edgar@email.com"));
        userData.put(1L, createUserData(6L, "Frank", "frank@email.com"));
        userData.put(1L, createUserData(7L, "George", "george@email.com"));
        userData.put(1L, createUserData(8L, "Helen", "helen@email.com"));
        userData.put(1L, createUserData(9L, "Illidan", "illidan@email.com"));
        userData.put(1L, createUserData(10L, "Jack", "jack@email.com"));
    }

    private UserEntity createUserData(long id, String name, String email) {
        return new UserEntity(id, name, email);
    }

}
