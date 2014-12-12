<!--I recommend using Markdown Syntax highlighting for this. Code and headers will be properly highlighted. -->

## Movement Logic (The 30,000 Foot View) ##

Since the board is two dimensional, but arrays are 1, I've used use a multidimensional array. The whole board is six-long, 2-high. Lateral movements require movement between along the first dimension of array (henceforth referred to as array `A`), while vertical movements require movement between the second (referred to as `B`, even though there are a total of six). Here's how the movements work:

Up:
: `B[1] -> B[0]`

Down:
: `B[0] -> B[1]`

Left:
: Where `x` is the starting position in `A`, do `A[x] -> A[x - 1]`.

Right:
: here `x` is the starting position in `A`, do `A[x] -> A[x + 1]`

Boundary errors aren't an issue, as boundary issues are handled a step before any actual movement.

## Implementation Details ##

The series of methods `bool isMove[direction]Possible` accepts the board, not the position structure. I chose this approach because there were odd pointer issues with passing in in a PositionBody — the method was reading garbage data, resulting in a `EXC_BAD_ACCESS` error. The Xcode debugger provided no useful insights besides what I just mentioned, so an executive decision was made to sidestep the issue entirely.

## Notes on Final Implementation ##

The code, while compiling, doesn't work due to a `SIGSEGV` error. Further inspection revealed that the crash was caused by `EXC_BAD_ACCESS` error at line 191, located in the hash function. The issue at hand is the item being passed in — `itemToHash`, of type `TypePosition` — is filled with garbage data. Hours of inspection revealed that the `TypePosition` structure being returned from the queue was filled was null. Unfortunately, despite considerable time and effort being spent trying to figure out why the queue was returning null, I was not able to find the reason within the given time constraints. It should be noted that this error only appeared after my troubles with Git (as noted emails sent to you), as a result of rewriting older code, and making mistakes along the way.

The difficulty with solving `EXC_BAD_ACCESS` errors is that the location of the crash *is not* the actual source of the error. To find the actual source, I had use Guard Malloc in Xcode's build schemes, which revealed the conclusions I described above.