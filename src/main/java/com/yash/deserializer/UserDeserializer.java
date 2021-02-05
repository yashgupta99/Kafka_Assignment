package com.yash.deserializer;

import com.yash.model.User;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;
import org.codehaus.jackson.map.ObjectMapper;

import java.util.Map;

public class UserDeserializer implements Deserializer {
    @Override
    public void configure(Map configs, boolean isKey) {

    }

    @Override
    public Object deserialize(String s, byte[] bytes) {
        ObjectMapper mapper = new ObjectMapper();
        User user = null;
        try {
            user = mapper.readValue(bytes, User.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }


    @Override
    public void close() {

    }
}
