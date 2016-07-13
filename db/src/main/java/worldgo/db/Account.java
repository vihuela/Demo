package worldgo.db;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * @author ricky.yao on 2016/7/13.
 */
@Table(name = "easeAccount")
public class Account {


    @Column(name = "nick")
    private String nick;
    @Column(name = "easeId", isId = true)
    private String easeId;
    @Column(name = "head")
    private String head;

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setEaseId(String easeId) {
        this.easeId = easeId;
    }

    public void setHead(String head) {
        this.head = head;
    }

    @Override
    public String toString() {
        return "Account{" +
                "nick='" + nick + '\'' +
                ", easeId='" + easeId + '\'' +
                ", head='" + head + '\'' +
                '}';
    }
}
