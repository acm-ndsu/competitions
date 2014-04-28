/* File: C.cpp
   Author:  Mark Fienup
   Description:  MICS 2014 Programming Contest Problem C - Word-Find Solver
   Finds the beginning and ending coordinates of specific words in a 
   2D word-find puzzle.
*/
#include <iostream>
#include <string>
using namespace std;

const bool PROMPTS = false;
const int MAX_SIZE = 101;

// prototyps
bool checkForWordStartingAt(string puzzle[MAX_SIZE], int puzzleSize, string word, int row, int col, 
			    int rowDir, int colDir);
bool checkForWordStartingInRec(string puzzle[MAX_SIZE], int puzzleSize, string word, 
			       int searchRowStart, int searchRowEnd, int searchColStart, int searchColEnd, 
			       int rowDir, int colDir, bool & foundWord);
void readPuzzle(string puzzle[MAX_SIZE], int & puzzleSize);
void printPuzzle(string puzzle[MAX_SIZE], int puzzleSize);

int main() {
  string puzzle[MAX_SIZE];
  string word;
  int puzzleSize, searchRowStart, searchRowEnd, searchColStart, searchColEnd, rowDir, colDir, wordSize;
  bool foundWord;
  
  readPuzzle(puzzle, puzzleSize);
  
  while (true) {
    if (PROMPTS) {
      cout << "Enter word to search for: ";
    } // end if
    getline(cin, word);
    if (word == "0") {
      break;
    } // end if
    wordSize = word.size();
    
    foundWord = false;
    
    // check left-to-right horizonally
    searchRowStart = 0;
    searchRowEnd = puzzleSize - 1;
    searchColStart = 0;
    searchColEnd = puzzleSize - wordSize;
    rowDir = 0;
    colDir = 1;
    checkForWordStartingInRec(puzzle, puzzleSize, word, searchRowStart, searchRowEnd, searchColStart, searchColEnd,
			      rowDir, colDir, foundWord);
    
    // check right-to-left horizonally
    searchRowStart = 0;
    searchRowEnd = puzzleSize - 1;
    searchColStart = wordSize - 1;
    searchColEnd = puzzleSize - 1;
    rowDir = 0;
    colDir = -1;
    checkForWordStartingInRec(puzzle, puzzleSize, word, searchRowStart, searchRowEnd, searchColStart, searchColEnd,
			      rowDir, colDir, foundWord);
    
    // check top-to-bottom vertically
    searchRowStart = 0;
    searchRowEnd = puzzleSize - wordSize;
    searchColStart = 0;
    searchColEnd = puzzleSize - 1;
    rowDir = 1;
    colDir = 0;
    checkForWordStartingInRec(puzzle, puzzleSize, word, searchRowStart, searchRowEnd, searchColStart, searchColEnd,
			      rowDir, colDir, foundWord);
    
    // check bottom-to-top vertically
    searchRowStart = wordSize - 1;
    searchRowEnd = puzzleSize - 1;
    searchColStart = 0;
    searchColEnd = puzzleSize - 1;
    rowDir = -1;
    colDir = 0;
    checkForWordStartingInRec(puzzle, puzzleSize, word, searchRowStart, searchRowEnd, searchColStart, searchColEnd,
			      rowDir, colDir, foundWord);
    
    // check top-left-to-bottom-right diagonally
    searchRowStart = 0;
    searchRowEnd = puzzleSize - wordSize;
    searchColStart = 0;
    searchColEnd = puzzleSize - wordSize;
    rowDir = 1;
    colDir = 1;
    checkForWordStartingInRec(puzzle, puzzleSize, word, searchRowStart, searchRowEnd, searchColStart, searchColEnd,
			      rowDir, colDir, foundWord);
    
    // check bottom-right-to-top-left diagonally
    searchRowStart = wordSize - 1;
    searchRowEnd = puzzleSize - 1;
    searchColStart = wordSize-1;
    searchColEnd = puzzleSize - 1;
    rowDir = -1;
    colDir = -1;
    checkForWordStartingInRec(puzzle, puzzleSize, word, searchRowStart, searchRowEnd, searchColStart, searchColEnd,
			      rowDir, colDir, foundWord);
    
    // check top-right-to-bottom-left diagonally
    searchRowStart = 0;
    searchRowEnd = puzzleSize - wordSize;
    searchColStart = wordSize-1;
    searchColEnd = puzzleSize - 1;
    rowDir = 1;
    colDir = -1;
    checkForWordStartingInRec(puzzle, puzzleSize, word, searchRowStart, searchRowEnd, searchColStart, searchColEnd,
			      rowDir, colDir, foundWord);
    
    // check bottom-left-to-top-right diagonally
    searchRowStart = wordSize - 1;
    searchRowEnd = puzzleSize - 1;
    searchColStart = 0;
    searchColEnd = puzzleSize - wordSize;
    rowDir = -1;
    colDir = 1;
    checkForWordStartingInRec(puzzle, puzzleSize, word, searchRowStart, searchRowEnd, searchColStart, searchColEnd,
			      rowDir, colDir, foundWord);
    
    if (!foundWord) {
      cout << word << ": Not found\n";
    } // end if
    
  } // end while
  
  if (PROMPTS) {
    printPuzzle(puzzle, puzzleSize);
  } // end if
  
} // end main


bool checkForWordStartingInRec(string puzzle[MAX_SIZE], int puzzleSize, string word, 
			       int searchRowStart, int searchRowEnd, int searchColStartRange, int searchColEndRange, 
			       int rowDir, int colDir, bool & foundWord) {
  int searchColStart, searchColEnd;

  while (!foundWord && searchRowStart <= searchRowEnd) {
    searchColStart = searchColStartRange;
    searchColEnd = searchColEndRange;
    while (!foundWord && searchColStart <= searchColEnd) {
      foundWord = checkForWordStartingAt(puzzle, puzzleSize, word, searchRowStart, searchColStart, rowDir, colDir);
      searchColStart += 1;
    } // end while
    searchRowStart += 1;
  } // end while
  return true;
} // end checkForWordStartingInRec


bool checkForWordStartingAt(string puzzle[MAX_SIZE], int puzzleSize, string word, int row, int col, int rowDir, int colDir) {
  int position, startRow = row;
  int startCol = col;
  for (position = 0; position < word.size(); position++) {
    if (puzzle[row][col] != word[position]) {
      return false;
    } // end if
    row += rowDir;
    col += colDir;
  } // end for
  cout << word << ": (" << startRow+1 << "," << startCol+1 << ") to (" << row-rowDir+1 << "," << col-colDir+1 << ")\n"; 
  return true;
} // end checkForWordStartingAt


void readPuzzle(string puzzle[MAX_SIZE], int & puzzleSize) {
  string temp;
  int r;
  
  if (PROMPTS) {
    cout << "Enter in the puzzle dimension: ";
  } // end if
  cin >> puzzleSize;
  getline(cin, temp);
  
  for (r = 0; r < puzzleSize; r++) {
    if (PROMPTS) {
      cout << "Enter row " << r+1 << " of the puzzle: ";
    } // end if

    getline(cin, puzzle[r]);
  } // end for r
} // end readPuzzle

void printPuzzle(string puzzle[MAX_SIZE], int puzzleSize) {
  string temp;
  int r, c;
  
  cout << "The puzzle is:" << endl;
  
  for (r = 0; r < puzzleSize; r++) {
    for (c = 0; c < puzzleSize; c++) {
      cout << puzzle[r][c];
    } // end for c
    cout << endl;
  } // end for r
} // end printPuzzle

