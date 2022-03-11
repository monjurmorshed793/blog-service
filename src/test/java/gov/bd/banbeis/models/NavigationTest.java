package gov.bd.banbeis.models;

import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@QuarkusTest
public class NavigationTest {

    @Test
    public void testNormalInsertion(){
       /* Navigation dashboard = new Navigation();
        dashboard.route="/dashboard";
        dashboard.label="dashboard";
        dashboard.icon = "dashboard-icon";

        Navigation employeeInfo = new Navigation();
        employeeInfo.route="/employeeInfo";
        employeeInfo.label="Personal Info";
        employeeInfo.icon="personal-icon";

        Navigation configuration = new Navigation();
        configuration.route="/configuration";
        configuration.label="configuration";
        configuration.icon = "configuration-icon";
        configuration.child = Arrays.asList(dashboard, employeeInfo);

        Uni<Navigation> savedConfiguration = configuration.persistOrUpdate();
        Navigation storedConfiguration = savedConfiguration.await().indefinitely();
        System.out.println("Printing saved id");
        System.out.println(storedConfiguration.id);
        System.out.println(storedConfiguration.toString());*/
        //Assertions.assertNotNull(configuration.id);
    }
}
