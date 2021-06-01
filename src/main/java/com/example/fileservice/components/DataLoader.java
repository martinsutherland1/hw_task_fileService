package com.example.fileservice.components;

import com.example.fileservice.models.File;
import com.example.fileservice.models.Folder;
import com.example.fileservice.models.User;
import com.example.fileservice.repositories.FileRepository;
import com.example.fileservice.repositories.FolderRepository;
import com.example.fileservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    FileRepository fileRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args){
        User user1 = new User("Martin Sutherland");
        userRepository.save(user1);
        User user2 = new User("Katelyn Hayes");
        userRepository.save(user2);

        Folder folder1 = new Folder("food", user1);
        folderRepository.save(folder1);
        Folder folder2 = new Folder("drink", user1);
        folderRepository.save(folder2);

        Folder folder3 = new Folder("houses", user2);
        folderRepository.save(folder3);
        Folder folder4 = new Folder("cars", user2);
        folderRepository.save(folder4);

        File file1 = new File("beef dishes", "txt", 50);
        fileRepository.save(file1);
        File file2 = new File("chicken dishes", "txt", 50);
        fileRepository.save(file2);
        File file3 = new File("beer", "txt", 50);
        fileRepository.save(file3);
        File file4 = new File("cola", "txt", 50);
        fileRepository.save(file4);
        File file5 = new File("flat", "txt", 50);
        fileRepository.save(file5);
        File file6 = new File("villa", "txt", 50);
        fileRepository.save(file6);
        File file7 = new File("mercedes", "txt", 50);
        fileRepository.save(file7);
        File file8 = new File("ford", "txt", 50);
        fileRepository.save(file8);

        folder1.addFile(file1);
        folder1.addFile(file2);
        folderRepository.save(folder1);

        folder2.addFile(file3);
        folder2.addFile(file4);
        folderRepository.save(folder2);

        folder3.addFile(file5);
        folder3.addFile(file6);
        folderRepository.save(folder3);

        folder4.addFile(file7);
        folder4.addFile(file8);
        folderRepository.save(folder4);










    }
}
