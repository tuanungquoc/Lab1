# Android Integer Calculator

- Requirements:
1. The calculator should have a basic UI that essentially complies with the attached wire frame. You can change the layout if you prefer.
2. Number Pad: 0-9
3. It needs to support operations and commands: +, - ,*, /, Clear, = 
4. A display for displaying the numbers (each number is up to 7 digits, not counting the - for negative numbers.)
5. No need to display operand on the display, only one number should be displayed at any given time
6. When the user enters 14 + 7 =,  it should display 14, then 7, and finally the result 21
7. Leading zeros should be discarded
8. When the user enters 0 0 4, you show 0 first, then still 0, and finally just 4, but not 004 or 04. This is true for calculation results as well.
9. It needs to be able to handle multiple operations in a sequence
  Example: 5+9-3+10
10. It should ONLY use the last operand if multiple operands are entered consecutively
  Example: “5++-1=” is equivalent to “5-1=”
11. Proper error handling and self correction.
12. “+-5” is equivalent to negative 5
13. “*/+-5” is equivalent to negative 5
14. 0004 + 32 ++ 0101 - - 04= is equivalent to 4+32+101-4=
15. 39 + 48 = - 10 + 5 - 98= is equivalent to 39+48-10+5-98=
16. Display should show 39, 48, 87, 10, 77,5, 82,98, -16
17. Integer operations only
18. Always rounding to the closest integer; when ambiguity occurs, rounding away from 0; e.g.
2 / 5 = 0
8 / 9 = 1
-7 / 6 = -1
5 / 2 = 3
-5 / 2 = -3
19. If divided by zero, or missing operand, e.g., *5=, or 5*=, show the error message ERROR!
20. Overflow handling: if the result is bigger than 9999999 or smaller than -9999999, show OVERFLOW! If any number of those ranges are typed in, show the same error message instantly as well.
