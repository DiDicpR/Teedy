package com.sismics.docs.core.dao.jpa;
import com.sismics.docs.BaseTransactionalTest;
import com.sismics.docs.core.dao.TagDao;
import com.sismics.docs.core.model.jpa.Tag;
import com.sismics.docs.core.util.TransactionUtil;
import org.junit.Assert;
import org.junit.Test;

public class TestN extends BaseTransactionalTest {
   @Test
    public void testNew() throws Exception {
        TagDao tagDao = new TagDao();
        Tag tag = new Tag();
        tag.setName("tag");
        tag.setColor("yellow");
        tag.setUserId("me");
        String id = tagDao.create(tag, "me");

        TransactionUtil.commit();

        tag = tagDao.getById(id);
        Assert.assertNotNull(tag);
        Assert.assertEquals("yellow", tag.getColor());

    }


}
