Report: Implementation and Analysis of the Knuth–Morris–Pratt (KMP) String Matching Algorithm
1. Introduction

  The objective of this project is to implement one string-matching algorithm from scratch in Java. The chosen algorithm is the Knuth–Morris–Pratt (KMP) algorithm, a classic and efficient method for substring searching. KMP improves upon the naive pattern matching approach by avoiding unnecessary character comparisons, thus achieving linear-time performance.

  This report presents the algorithm’s implementation details, testing results on strings of various lengths, and an analysis of its time and space complexity.

2. Algorithm Overview

  The KMP algorithm searches for occurrences of a pattern string P within a text string T using preprocessing of the pattern. The preprocessing step constructs an array called the Longest Prefix Suffix (LPS) array, which indicates the longest proper prefix of the pattern that is also a suffix for each position.
This allows the algorithm to efficiently skip parts of the text without re-checking previously matched characters.

3. Implementation

  The algorithm was implemented fully in Java without using any external libraries.
  The implementation consists of two main functions:

  computeLPSArray() – Preprocesses the pattern to compute the LPS array.

  KMPSearch() – Uses the LPS array to search for all occurrences of the pattern in the text efficiently.

  Comprehensive comments were added throughout the code to explain the workflow, logic, and data flow.

  The main testing section includes three input cases:

  A short string,

  A medium-length string, and

  A long string with over 2000 characters.

4. Testing and Results
  Test Case	Text Length	Pattern	Result (Indices Found)
  Short string	19	"ABABCABAB"	10
  Medium string	59	"MEDIUM"	7
  Long string	2001	"AAAB"	997

  Observations:

  For short strings, the algorithm completes almost instantly.

  For medium-length inputs, performance remains consistent, with negligible delays.

  For long strings (2000+ characters), the algorithm still executes in linear time, showing scalability and efficiency.

  This demonstrates that KMP maintains stable performance regardless of string size, which confirms its theoretical efficiency.

5. Complexity Analysis
  Time Complexity:

  Preprocessing (LPS array): O(m), where m is the length of the pattern.

  Search Phase: O(n), where n is the length of the text.

  Total: O(n + m)

  This linear time complexity is a major improvement over the naive algorithm, which can take O(n × m) in the worst case.

  Space Complexity:

  The algorithm requires an additional array (lps[]) of size m.

  Therefore, space complexity = O(m).

6. Conclusion

  The Knuth–Morris–Pratt algorithm was successfully implemented and tested in Java.
  Results confirmed that KMP performs efficiently across short, medium, and long strings. Its ability to avoid redundant comparisons makes it ideal for real-world    applications involving large texts such as document searching or DNA sequence analysis.

  The project demonstrates a clear understanding of string processing efficiency and highlights the importance of preprocessing in optimizing algorithmic performance.
