package jinx;

import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.record.impl.ODocument;

/**
 * JAVA操作orientDB数据库
 */
public class OrientDBTest {

    /**
     * orientDB插入一条数据
     * @param name
     */
    public static void insert(String name){
        //数据库连接
        ODatabaseDocumentTx db = new ODatabaseDocumentTx("remote:localhost/jinx").open("root", "root");
        //选择表
        ODocument doc = new ODocument("Jinx");
        //设置插入值
        doc.field( "name",name);
        //保存操作
        doc.save();
        //关闭连接
        db.close();
    }

    public static void main(String[] args){
        insert("jinx007");
    }

}
