package org.iesfm.library;

import org.junit.Assert;
import org.junit.Test;

public class MemberTests {

    @Test
    public void isFromTests() {
        Member member = new Member("K54937531", 1, "Antonio", "Pineda", 20323);
        Assert.assertTrue(member.isFrom(20323));
    }

    @Test
    public void isNotFromTests() {
        Member member = new Member("K54937531", 1, "Antonio", "Pineda", 20323);
        Assert.assertFalse("Los códigos postales no coinciden, por lo tanto se devielve false",member.isFrom(23426));
    }
}
