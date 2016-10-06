package dennis.markmann.MyLibraries.DefaultJobs.File;

import java.io.File;
import java.util.ArrayList;

public class FileFilter {

    ArrayList<FileType> fileTypes = new ArrayList<>();

    public void addDocuments() {
        this.fileTypes.add(FileType.TXT);
        this.fileTypes.add(FileType.PDF);
        this.fileTypes.add(FileType.XML);
        this.fileTypes.add(FileType.CSV);
    }

    public void addExecutable() {
        this.fileTypes.add(FileType.EXE);
    }

    public void addFileTypes(ArrayList<FileType> fileTypes) {
        this.fileTypes.addAll(fileTypes);
    }

    public FileFilter addMovies() {
        this.fileTypes.add(FileType.MKV);
        this.fileTypes.add(FileType.MP4);
        this.fileTypes.add(FileType.AVI);
        return this;
    }

    public void addMusic() {
        this.fileTypes.add(FileType.MP3);
    }

    public void addTextFiles() {
        this.fileTypes.add(FileType.TXT);
    }

    public ArrayList<File> filter(ArrayList<File> fileList) {
        ArrayList<File> filteredList = new ArrayList<>();

        for (File file : fileList) {
            if (!file.isDirectory()) {
                final String fileName = file.getName().toLowerCase();

                for (FileType type : this.fileTypes) {
                    if (fileName.endsWith(type.toString())) {
                        filteredList.add(file);
                    }
                }
            }
        }
        return filteredList;
    }
}
