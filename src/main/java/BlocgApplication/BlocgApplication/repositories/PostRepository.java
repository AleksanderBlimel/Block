package BlocgApplication.BlocgApplication.repositories;

import BlocgApplication.BlocgApplication.Controllers.MainController;
import BlocgApplication.BlocgApplication.models.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
