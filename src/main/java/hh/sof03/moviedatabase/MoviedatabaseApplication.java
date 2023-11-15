package hh.sof03.moviedatabase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof03.moviedatabase.domain.Director;
import hh.sof03.moviedatabase.domain.DirectorRepository;
import hh.sof03.moviedatabase.domain.Genre;
import hh.sof03.moviedatabase.domain.GenreRepository;
import hh.sof03.moviedatabase.domain.Movie;
import hh.sof03.moviedatabase.domain.MovieRepository;
import hh.sof03.moviedatabase.domain.User;
import hh.sof03.moviedatabase.domain.UserRepository;

@SpringBootApplication
public class MoviedatabaseApplication {

	private static final Logger log = LoggerFactory.getLogger(MoviedatabaseApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MoviedatabaseApplication.class, args);
	}

	@Bean
	public CommandLineRunner movieDemo(MovieRepository movieRepo, GenreRepository genreRepo, DirectorRepository directorRepo, UserRepository userRepo) {
		return (args) -> {
			genreRepo.save(new Genre("Sci-Fi"));
			genreRepo.save(new Genre("Historical"));
			genreRepo.save(new Genre("Fantasy"));
			genreRepo.save(new Genre("Action"));
			genreRepo.save(new Genre("Adventure"));
			genreRepo.save(new Genre("Horror"));

			directorRepo.save(new Director("Ridley Scott"));
			directorRepo.save(new Director("Christopher Nolan"));
			directorRepo.save(new Director("Peter Jackson"));
			directorRepo.save(new Director("George Lucas"));
			directorRepo.save(new Director("James Cameron"));
			directorRepo.save(new Director("Denis Villeneuve"));

			movieRepo.save(new Movie("Gladiator", "A former Roman General sets out to exact vengeance against the corrupt emperor who murdered his family and sent him into slavery.", "ty8TGRuvJLPUmAR1H1nRIsgwvim.jpg", 2000, directorRepo.findByName("Ridley Scott"), genreRepo.findByName("Historical")));
			movieRepo.save(new Movie("Kingdom of Heaven", "Balian of Ibelin travels to Jerusalem during the Crusades of the 12th century, and there he finds himself as the defender of the city and its people.", "uk55nBEFIQFveIiy9jvLGiVtk4h.jpg", 2005, directorRepo.findByName("Ridley Scott"), genreRepo.findByName("Historical")));
			movieRepo.save(new Movie("Alien", "The crew of a commercial spacecraft encounters a deadly lifeform after investigating an unknown transmission.", "vfrQk5IPloGg1v9Rzbh2Eg3VGyM.jpg", 1979, directorRepo.findByName("Ridley Scott"), genreRepo.findByName("Horror")));
			movieRepo.save(new Movie("Blade Runner", "A blade runner must pursue and terminate four replicants who stole a ship in space and have returned to Earth to find their creator.", "63N9uy8nd9j7Eog2axPQ8lbr3Wj.jpg", 1982, directorRepo.findByName("Ridley Scott"), genreRepo.findByName("Sci-Fi")));
			
			movieRepo.save(new Movie("Interstellar", "When Earth becomes uninhabitable in the future, a farmer and ex-NASA pilot, Joseph Cooper, is tasked to pilot a spacecraft, along with a team of researchers, to find a new planet for humans.", "gEU2QniE6E77NI6lCU6MxlNBvIx.jpg", 2014, directorRepo.findByName("Christopher Nolan") , genreRepo.findByName("Sci-Fi")));
			movieRepo.save(new Movie("Inception", "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O., but his tragic past may doom the project and his team to disaster.", "oYuLEt3zVCKq57qu2F8dT7NIa6f.jpg", 2010, directorRepo.findByName("Christopher Nolan") , genreRepo.findByName("Adventure")));
			movieRepo.save(new Movie("The Dark Knight", "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.", "qJ2tW6WMUDux911r6m7haRef0WH.jpg", 2008, directorRepo.findByName("Christopher Nolan") , genreRepo.findByName("Action")));
			
			movieRepo.save(new Movie("The Lord of the Rings: The Fellowship of the Ring", "A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle-earth from the Dark Lord Sauron.", "6oom5QYQ2yQTMJIbnvbkBL9cHo6.jpg", 2001, directorRepo.findByName("Peter Jackson") , genreRepo.findByName("Fantasy")));
			movieRepo.save(new Movie("The Lord of the Rings: The Two Towers", "While Frodo and Sam edge closer to Mordor with the help of the shifty Gollum, the divided fellowship makes a stand against Sauron's new ally, Saruman, and his hordes of Isengard.", "5VTN0pR8gcqV3EPUHHfMGnJYN9L.jpg", 2002, directorRepo.findByName("Peter Jackson") , genreRepo.findByName("Fantasy")));
			movieRepo.save(new Movie("The Lord of the Rings: The Return of the King", "Gandalf and Aragorn lead the World of Men against Sauron's army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.", "rCzpDGLbOoPwLjy3OAm5NUPOTrC.jpg", 2003, directorRepo.findByName("Peter Jackson") , genreRepo.findByName("Fantasy")));
			
			movieRepo.save(new Movie("Star Wars: Episode V - The Empire Strikes Back", "After the Rebels are overpowered by the Empire, Luke Skywalker begins his Jedi training with Yoda, while his friends are pursued across the galaxy by Darth Vader and bounty hunter Boba Fett.", "nNAeTmF4CtdSgMDplXTDPOpYzsX.jpg", 1980, directorRepo.findByName("George Lucas") , genreRepo.findByName("Sci-Fi")));
		
			movieRepo.save(new Movie("Terminator 2: Judgment Day", "A cyborg, identical to the one who failed to kill Sarah Connor, must now protect her ten year old son John from an even more advanced and powerful cyborg.", "5M0j0B18abtBI5gi2RhfjjurTqb.jpg", 1991, directorRepo.findByName("James Cameron") , genreRepo.findByName("Action")));
		
			movieRepo.save(new Movie("Arrival", "A linguist works with the military to communicate with alien lifeforms after twelve mysterious spacecraft appear around the world.", "x2FJsf1ElAgr63Y3PNPtJrcmpoe.jpg", 2016, directorRepo.findByName("Denis Villeneuve") , genreRepo.findByName("Sci-Fi")));
			movieRepo.save(new Movie("Dune", "A noble family becomes embroiled in a war for control over the galaxy's most valuable asset while its heir becomes troubled by visions of a dark future.", "d5NXSklXo0qyIYkgV94XAgMIckC.jpg", 2021, directorRepo.findByName("Denis Villeneuve") , genreRepo.findByName("Sci-Fi")));
		

			userRepo.save(new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER"));
			userRepo.save(new User("admin", "$2a$10$g7LYNNvVePos9SFcMlsSKOtUbEMhBnm/uRUr3EWDXw36E5sEfGfbm", "ADMIN"));

			log.info("succesful");
		};
	}

}
