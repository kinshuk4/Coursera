You have now successfully mastered
the generation of Sigma Points,

and even implemented an example in C++.

Really great job, and you know what?

This was the most difficult and

complicated part, all the remaining
steps will be much simpler.

Let's move on the prediction
of Sigma Points.

What we have now is this matrix
of augmented Sigma Points.

For the prediction step,

we simply insert every Sigma Point
into the process model.

Again, we store every predicted
Sigma Point as a column of a matrix,

we call this matrix calligraphic Xk+1|k.

When you will bring this to C++ code,

the main thing you have to do
is implement this process model.

One thing you should also consider,
the input to the process model

is a seven dimensional Augmented vector,
which makes sense.

These are five state dimensions and
two noise dimensions.

The output is a five dimensional vector,

because this is what the process
model returns, that means

the matrix with the predicted Sigma
Points has five rows and 15 columns.

All right,

that's everything you need to know
about the prediction of Sigma Points.

Let's see if you can
implement this in C++.