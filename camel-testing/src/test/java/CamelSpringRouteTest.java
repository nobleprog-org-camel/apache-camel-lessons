import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class CamelSpringRouteTest extends CamelSpringTestSupport{

    private String inputDir;
    private String outputDir;

    @EndpointInject(uri = "file:{{input.dir}}")
    private ProducerTemplate inbox;

    public void setUp() throws Exception {
        super.setUp();
        inputDir = context.resolvePropertyPlaceholders("{{input.dir}}");
        outputDir = context.resolvePropertyPlaceholders("{{output.dir}}");

        deleteDirectory(inputDir);
        deleteDirectory(outputDir);
    }

    @Override
    protected AbstractApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext();
    }

    @Test
    public void testRoute() throws InterruptedException {
        inbox.sendBodyAndHeader("File Content", Exchange.FILE_NAME,"test.txt");

        TimeUnit.SECONDS.sleep(2);

        File fil1 = new File(outputDir);
        System.out.println(fil1.exists());
        File file = new File(outputDir+"/test.txt");
        assertTrue(file.exists());
    }
}
