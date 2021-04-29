package org.iesfm.generic.user;

import org.iesfm.generic.Serializer;
import org.junit.Assert;
import org.junit.Test;

public class UserSerializerTest {

    @Test
    public void UserSerializerTests() {
        Serializer<User> userSerializer = new UserSerializer();

        User user = new User("Teo", "12345", 10);

        String expected = "username:Teo,password:12345,level:10";

        String serializerUser = userSerializer.serialize(user);

        Assert.assertEquals(expected, serializerUser);
    }
}
