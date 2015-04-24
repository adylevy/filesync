package FileSync.ServerData.SDK;
import java.net.URI;

import FileSync.ServerData.DataTypes.UserDT;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

/**
 * Created by Ady on 3/18/2015.
 */
public class User {

    public static void Login(String username,String password){
        try {

            Client client = ClientBuilder.newClient();
            WebTarget target = client.target("http://localhost:1337/user").path("findById");

            Form form = new Form();
            form.param("x", "foo");
            form.param("y", "bar");

            UserDT bean =
                    target.request(MediaType.APPLICATION_JSON_TYPE)
                            .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE),
                                    UserDT.class);
            System.out.println("Server response .... \n");
           // System.out.println(output);

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

}
