package com.aar.app.wordsearch.data;

import com.aar.app.wordsearch.model.Word;

import java.util.List;


public interface WordDataSource {

    List<Word> getWords();

}
