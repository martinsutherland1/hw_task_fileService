package com.example.fileservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "files")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "extension")
    String extension;

    @Column(name = "size")
    int size;

    @ManyToMany
    @JsonIgnoreProperties({"files"})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "folders_files",
            joinColumns = {@JoinColumn(name = "file_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "folder_id", nullable = false, updatable = false)}

    )
    private List<Folder> folders;


    public File(String name, String extension, int size) {
        this.name = name;
        this.extension = extension;
        this.size = size;

    }

    public File() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Folder> getFolders(){
        return folders;
    }

    public void addFolder(Folder folder){
        this.folders.add(folder);
    }
}
