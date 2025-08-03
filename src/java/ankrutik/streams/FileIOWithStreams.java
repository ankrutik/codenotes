package ankrutik.streams;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileIOWithStreams {
    public static void main(String[] args) {
        String filename = "/home/krutik/projects/learn/codenotes/src/java/ankrutik/streams/samplefile.txt";
        // may have to adjust above filepath
        try(Stream<String> streamOfLines = Files.lines(Paths.get(filename))) {
            streamOfLines.forEach(s -> {
                System.out.println(s);
            });
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
