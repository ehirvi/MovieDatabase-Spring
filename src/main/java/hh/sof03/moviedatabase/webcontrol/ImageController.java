package hh.sof03.moviedatabase.webcontrol;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.sof03.moviedatabase.domain.MovieRepository;

@Controller
@RequestMapping("/images")
public class ImageController {

    @Value("${upload.path}")
    private String IMG_DIR;
    private final ResourceLoader resourceLoader;

    public ImageController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Autowired
    private MovieRepository movieRepository;
    
    @GetMapping("/movie/{id}")
    public ResponseEntity<Resource> getMovieImg(@PathVariable("id") Long id) {
        String fileName = movieRepository.findById(id).get().getImgFile();

        if (fileName.length() != 0) {
            Path path = Paths.get(IMG_DIR + fileName);
            Resource resource = resourceLoader.getResource("file:" + path.toString());
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(resource);
        }
        return null;
    }

}
