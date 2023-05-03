package com.antsrl.formazione.springbasics.service;

import com.antsrl.formazione.springbasics.uimodel.Song;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class SongService {

    private static final List<Song> songList = Collections.synchronizedList(new ArrayList<>());
    private static AtomicLong songListId = new AtomicLong();

    static {

        saveInternal(Song.builder()
                .title("Bella Song")
                .url("https://yoube.com/sdfsfs")
                .build());

        saveInternal(Song.builder()
                .title("Good Song")
                .url("https://yoube.com/sdfsfs")
                .build());

        saveInternal(Song.builder()
                .title("Wow Song")
                .url("https://yoube.com/sdfsfs")
                .build());

    }

    public List<Song> getAllSongs() {
        return songList;
    }

    public void save(Song song) {
        saveInternal(song);
    }

    private static void saveInternal(Song song) {

        if(Objects.isNull(song.getId())){

            song.setId(songListId.incrementAndGet());
        }

        songList.add(song);
    }

    public void delete(Long id) {
        songList.stream()
                .filter(song -> Objects.equals(id, song.getId()))
                .findFirst()
                .ifPresent(songList::remove);
    }
}

