# JsonFlattener
Util to convert a json string to Flattened String

Ex : Input
{
"a": 1,
"b": true,
"c": {
"d": 3,
"e": "test"
}
}

Output:
{
"a": 1.0, //not primitive
"b": true,
"c.d": 3.0, //not primitive
"c.e": "test"
}

# Assumption
Values returned from response will be object instead of primitive as mentioned
above.

# Required
java 1.8
maven

# How to run
JsonFlatten is main class, expects json string from input stream
ex: cat input.txt | JsonFlatten 

# Output
Prints Input string and flattened json string
