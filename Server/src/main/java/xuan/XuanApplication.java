package xuan;

import org.springframework.stereotype.Indexed;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author 善待
 */
@Indexed
@SpringBootApplication
public class XuanApplication {

    public static void main(String[] args) {

        SpringApplication.run(XuanApplication.class, args);
        System.out.println("项目已启动");

    }


}
