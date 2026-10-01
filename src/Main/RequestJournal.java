package Main;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class RequestJournal {
    private final Path path;

    public RequestJournal(Path path) {
        this.path = path;
    }

    public void add(String description) throws IOException, IllegalAccessException {
        if (description.isBlank()){
            throw new IllegalAccessException("Описание заявки не должно быть пустым");
        }

        String entry = description.strip() + System.lineSeparator();
        Files.writeString(path, entry, StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }
    public String readAll() throws IOException{
        return Files.readString(path,StandardCharsets.UTF_8);
    }
}
