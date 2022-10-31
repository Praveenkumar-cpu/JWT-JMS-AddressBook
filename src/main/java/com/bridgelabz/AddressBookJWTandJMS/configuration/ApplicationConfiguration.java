package com.bridgelabz.AddressBookJWTandJMS.configuration;

import com.bridgelabz.AddressBookJWTandJMS.utility.EmailSenderService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApplicationConfiguration {

    //Password Hashing function
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //it avoid having to write boilerplate code to map DTOs into entities and vice-verse we are using library called
    //ModelMapper

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    //.select api related information
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bridgelabz"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public EmailSenderService emailSenderService(){
        return new EmailSenderService();
    }








//    @Autowired
//    private JavaMailSender mailSender;
//
//
//    public void sendSimpleEmail(String toEmail,
//                                String body,
//                                String subject){
//



}
