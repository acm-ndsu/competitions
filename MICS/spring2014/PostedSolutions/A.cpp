/* File: A.cpp
   Author:  Mark Fienup
   Description:  MICS 2014 Programming Contest Problem A - EPIC
   Prints scalable ASCII art of the letters EPIC vertically.
 */
#include <iostream>
using namespace std;

// prototyps
void  printE(int scalingFactor);
void  printP(int scalingFactor);
void  printI(int scalingFactor);
void  printC(int scalingFactor);
void  printBlankLines(int scalingFactor);

const bool PROMPTS = false;
const int LETTER_DIM_MULTIPLIER = 5;

int main() {
  int scalingFactor;

  if (PROMPTS) {
    cout << "Enter scaling factor: ";
  } // end if

  cin >> scalingFactor;

  printE(scalingFactor);
  printBlankLines(scalingFactor);

  printP(scalingFactor);
  printBlankLines(scalingFactor);

  printI(scalingFactor);
  printBlankLines(scalingFactor);

  printC(scalingFactor);


} // end main

void  printE(int scalingFactor) {
  int letterDim = scalingFactor * LETTER_DIM_MULTIPLIER;
  int r;
  int c;

  // top of E
  for (r = 0; r < scalingFactor; r++) {
    for (c = 0; c < letterDim; c++) {
      cout << 'E';
    } // end for c
    cout << endl;
  } // end for r

  // top side of E
  for (r = 0; r < scalingFactor; r++) {
    for (c = 0; c < scalingFactor; c++) {
      cout << 'E';
    } // end for c
    for (; c < letterDim; c++) {
      cout << ' ';
    } // end for c
    cout << endl;
  } // end for r

  // middle of E
  for (r = 0; r < scalingFactor; r++) {
    for (c = 0; c < letterDim; c++) {
      cout << 'E';
    } // end for c
    cout << endl;
  } // end for r

  // bottom side of E
  for (r = 0; r < scalingFactor; r++) {
    for (c = 0; c < scalingFactor; c++) {
      cout << 'E';
    } // end for c
    for (; c < letterDim; c++) {
      cout << ' ';
    } // end for c
    cout << endl;
  } // end for r

  // bottom of E
  for (r = 0; r < scalingFactor; r++) {
    for (c = 0; c < letterDim; c++) {
      cout << 'E';
    } // end for c
    cout << endl;
  } // end for r

} // end printE


void  printP(int scalingFactor) {
  int letterDim = scalingFactor * LETTER_DIM_MULTIPLIER;
  int r;
  int c;

  // top of E
  for (r = 0; r < scalingFactor; r++) {
    for (c = 0; c < letterDim; c++) {
      cout << 'P';
    } // end for c
    cout << endl;
  } // end for r

  // top side of E
  for (r = 0; r < scalingFactor; r++) {
    for (c = 0; c < scalingFactor; c++) {
      cout << 'P';
    } // end for c
    for (; c < letterDim-scalingFactor; c++) {
      cout << ' ';
    } // end for c
    for (c = 0; c < scalingFactor; c++) {
      cout << 'P';
    } // end for c
    cout << endl;
  } // end for r

  // middle of E
  for (r = 0; r < scalingFactor; r++) {
    for (c = 0; c < letterDim; c++) {
      cout << 'P';
    } // end for c
    cout << endl;
  } // end for r

  // bottom side of E
  for (r = 0; r < scalingFactor*2; r++) {
    for (c = 0; c < scalingFactor; c++) {
      cout << 'P';
    } // end for c
    for (; c < letterDim; c++) {
      cout << ' ';
    } // end for c
    cout << endl;
  } // end for r

} // end printP

void  printI(int scalingFactor) {
  int letterDim = scalingFactor * LETTER_DIM_MULTIPLIER;
  int r, c, blanks;

  // top of I
  for (r = 0; r < scalingFactor; r++) {
    for (c = 0; c < letterDim; c++) {
      cout << 'I';
    } // end for c
    cout << endl;
  } // end for r

  // middle of I
  blanks = (letterDim - scalingFactor) / 2;
  for (r = 0; r < scalingFactor*3; r++) {
    for (c = 0; c < blanks; c++) {
      cout << ' ';
    } // end for c
    for (c = 0; c < scalingFactor; c++) {
      cout << 'I';
    } // end for c
    for (c = 0; c < blanks; c++) {
      cout << ' ';
    } // end for c
    cout << endl;
  } // end for r

  // bottom of I
  for (r = 0; r < scalingFactor; r++) {
    for (c = 0; c < letterDim; c++) {
      cout << 'I';
    } // end for c
    cout << endl;
  } // end for r


} // end printI

void  printC(int scalingFactor) {
  int letterDim = scalingFactor * LETTER_DIM_MULTIPLIER;
  int r, c;

  // top of C
  for (r = 0; r < scalingFactor; r++) {
    for (c = 0; c < letterDim; c++) {
      cout << 'C';
    } // end for c
    cout << endl;
  } // end for r

  // top side of C
  for (r = 0; r < scalingFactor*3; r++) {
    for (c = 0; c < scalingFactor; c++) {
      cout << 'C';
    } // end for c
    for (; c < letterDim; c++) {
      cout << ' ';
    } // end for c
    cout << endl;
  } // end for r

  // bottom of C
  for (r = 0; r < scalingFactor; r++) {
    for (c = 0; c < letterDim; c++) {
      cout << 'C';
    } // end for c
    cout << endl;
  } // end for r

} // end printC

void  printBlankLines(int scalingFactor) {
  int r;
  for (r =0; r < scalingFactor; r++) {
    cout << endl;
  } // end for 

} // end printBlankLines

