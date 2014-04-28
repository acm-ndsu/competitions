/* File: B.cpp
   Author:  Mark Fienup
   Description:  MICS 2014 Programming Contest Problem B - Even-Odd sort
   The "even-odd sort" arranges positive integers such that:
   * smallest even integer is at index 0,
   * smallest odd integer is at index 1,
   * second smallest even integer is at index 2,
   * second smallest odd integer is at index 3, etc.
   * pattern continues until either the even or odd numbers 
     run out, then the remain values are in ascending order.
 */
#include <iostream>
using namespace std;

// prototype
void selectionSort(int numbers[], int size);
void readNumbers(int evens[], int odds[], int & evenCnt, int & oddCnt);
void printArray(int numbers[], int size);

const bool PROMPTS = false;
const int MAX_SIZE = 1000;

int main() {
  int evens[MAX_SIZE];
  int odds[MAX_SIZE];
  int evenOddSorted[MAX_SIZE];
  int evenCnt, oddCnt, evenIndex, oddIndex, evenOddIndex;

  if (PROMPTS) {
    cout << "Enter positive integers with 0 to end: ";
  } // end if

  readNumbers(evens, odds, evenCnt, oddCnt);
  selectionSort(evens, evenCnt);
  selectionSort(odds, oddCnt);

  if (PROMPTS) {
    cout << "\nSorted Evens:" << endl;
    printArray(evens, evenCnt);
    cout << "\nSorted Odds:" << endl;
    printArray(odds, oddCnt);
    cout << endl;
  } // end if

  evenIndex = 0;
  oddIndex = 0;
  evenOddIndex = 0;
  while (evenIndex < evenCnt && oddIndex < oddCnt) {
    evenOddSorted[evenOddIndex++] = evens[evenIndex++];
    evenOddSorted[evenOddIndex++] = odds[oddIndex++];
  } // end while
  while (evenIndex < evenCnt) {
    evenOddSorted[evenOddIndex++] = evens[evenIndex++];
  } // end while
  while (oddIndex < oddCnt) {
    evenOddSorted[evenOddIndex++] = odds[oddIndex++];
  } // end while

  if (PROMPTS) {
    cout << "\nEven-Odd Sorted Array:" << endl;
  } // end if
  printArray(evenOddSorted, evenOddIndex);
} // end main

void printArray(int numbers[], int size) {
  int i;

  for( i = 0; i < size; i++) {
    cout << numbers[i] << endl;
  } // end for
} // end printArray


void selectionSort(int numbers[], int size) {
  int lastUnsorted, maxIndex, testIndex;

  for (lastUnsorted = size-1; lastUnsorted >= 1; lastUnsorted--) {
    maxIndex = 0;
    for (testIndex = 1; testIndex <= lastUnsorted; testIndex++) {
      if (numbers[testIndex] > numbers[maxIndex]) {
	maxIndex = testIndex;
      } // end if
    } // end for (testIndex
    int temp = numbers[lastUnsorted];
    numbers[lastUnsorted] = numbers[maxIndex];
    numbers[maxIndex] = temp;

  } // end for (lastUnsorted

} // end selectionSort


void readNumbers(int evens[], int odds[], int & evenCnt, int & oddCnt) {
  int value;

  evenCnt = 0;
  oddCnt = 0;
  while (true) {
    cin >> value;
    if (value == 0) {
      break;
    } // end if
    if (value%2 == 0) {
      evens[evenCnt] = value;
      evenCnt++;
    } else {
      odds[oddCnt] = value;
      oddCnt++;
    } // end if
  } // end while
} // end readNumbers

