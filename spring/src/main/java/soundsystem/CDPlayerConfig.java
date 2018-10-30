package soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//@ComponentScan
@Import(CDConfig.class)
public class CDPlayerConfig {

//    @Bean(name="sgtPeppers")
//    public CompactDisc sgtPeppers(){
//        return new SgtPeppers();
//    }

//    @Bean
//    public MediaPlayer mediaPlayer(){
//        // spring会自动拦截方法，确保sgtPeppers()走的是bean，而不是重新创建
//        return new CDPlayer(sgtPeppers());
//    }

    @Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc){
        return new CDPlayer(compactDisc);
    }
}
