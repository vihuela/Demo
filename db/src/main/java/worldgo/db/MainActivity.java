package worldgo.db;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.xutils.DbManager;
import org.xutils.db.Selector;
import org.xutils.ex.DbException;
import org.xutils.x;

import java.security.SecureRandom;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DbManager db;

    private String[] ids = new String[]{"ztx111", "ztx112", "ztx113"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DbManager.DaoConfig daoConfig = new DbManager.DaoConfig();
        daoConfig.setDbName("easeAccountDB.db");
        daoConfig.setDbOpenListener(new DbManager.DbOpenListener() {
            @Override
            public void onDbOpened(DbManager db) {
                db.getDatabase().enableWriteAheadLogging();
            }
        });
        db = x.getDb(daoConfig);


    }

    public void add(View view) throws DbException {
        Account account = new Account();
        String id = ids[new SecureRandom().nextInt(3)];
        account.setEaseId(id);
        account.setHead("head_123");
        account.setNick("nick_123");
        System.out.println("insert " + id);
        db.saveOrUpdate(account);
    }

    public void clear(View view) throws DbException {
        db.dropTable(Account.class);
    }

    public void getAll(View view) throws DbException {
        List<Account> all1 = db.selector(Account.class).findAll();
        if (all1 != null)
            for (Account a : all1)
                System.out.println(a.toString());
    }
}
