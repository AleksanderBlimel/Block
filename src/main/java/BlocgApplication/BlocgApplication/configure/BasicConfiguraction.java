package BlocgApplication.BlocgApplication.configure;


import BlocgApplication.BlocgApplication.models.dto.PostDTO;
import BlocgApplication.BlocgApplication.models.entities.Post;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BasicConfiguraction {


    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.createTypeMap(Post.class, PostDTO.class)
                .addMapping(pst -> pst.getUser().getId(), PostDTO::setIdOfUser)
                .addMapping(pst -> pst.getAudit().getAdded(), PostDTO::setCreated);

        return modelMapper;
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
