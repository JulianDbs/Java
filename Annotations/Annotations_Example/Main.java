import java.lang.Override;
import java.lang.Deprecated;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Main {
  public static void main(String[] args) {
    TheLordOfTheRings_I_VHS movie = new TheLordOfTheRings_I_VHS();
    checkAnnotation(movie);
    movie.play();
  }

  public static void checkAnnotation(Object o) {
    if (o == null) {
      System.out.println("This Object is null.");
    } else {
      if (o.getClass().isAnnotationPresent(VHS.class)) {
        System.out.println("\nThis Object have the @VHS Annotation.");
        VHS vhs = o.getClass().getAnnotation(VHS.class);
        System.out.println("Movie Name -> " + vhs.movieName());
        System.out.println("Date Release -> " + vhs.movieDate());
      } else {
        System.out.println("\nThis Object does not have the @VHS Annotation.");
      }
    }
  }
}

@Deprecated
public class VideoHomeSystem {
  public final String name;
  public VideoHomeSystem(String name){
    this.name = name;
  }

  public void play() {}

  public void stop() {}

  public void pause() {}
}

@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface VHS {
  String movieName() default "N/A";
  String movieDate() default "N/A";
}


@VHS(
  movieName = "The Lord of the Rings : The Fellowship of the Ring",
  movieDate = "12/19/2001"
)
public class TheLordOfTheRings_I_VHS extends VideoHomeSystem {
  public TheLordOfTheRings_I_VHS(){
    super("The Lord of the Rings : The Fellowship of the Ring");
  }

  @Override
  public void play() {
    System.out.println(
      "\n\t\tYou Wouldn't Steal a Car" +
      "\n\t\tYou Wouldn't Steal a Handbag" +
      "\n\t\tYou Wouldn't Steal a Television" +
      "\n\t\tYou Wouldn't Steal a DVD\n" +
      "\n\t\tDownloading" +
      "\n\t\tPirated" +
      "\n\t\tFilms" +
      "\n\t\tis Stealing.\n" +
      "\n\t\tStealing" +
      "\n\t\tis Against" +
      "\n\t\tthe Law.\n" +
      "\n\t\tPiracy it's a Crime.\n" +
      "\n\t| I |\tIllegal Downloading" +
      "\n\t\tInappropiate for All Ages\n\n\n" +
      this.name +
      "\n\n\t\tI amar prestar aen…" +
      "\n\t\tThe world is changed.\n" +
      "\n\t\than mathon ne nen…" +
      "\n\t\tI feel it in the water.\n" +
      "\n\t\than mathon ne chae…" +
      "\n\t\tI feel it in the Earth.\n" +
      "\n\t\ta han noston ned gwilith." +
      "\n\t\tI smell it in the air.\n" +
      "\nMuch that once was is lost. For none now live who remember it ..."
    );
  }
}
