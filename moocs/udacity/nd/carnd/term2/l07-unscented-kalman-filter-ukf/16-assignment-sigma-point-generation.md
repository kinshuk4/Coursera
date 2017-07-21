Welcome to the first coding
quiz in this lesson.

Let's go ahead and
put what we have learned into C++.

In this quiz you will write a small
function that generates Sigma Points.

I've prepared the template for you and

I would like to quickly
make you familiar with it.

You will be working on a function
called generate Sigma Points.

Which receives a pointer
to a matrix as input.

This is where you are expected
to write your result.

I will show you how this works
in the end of the function.

This time, we will consider
the complete state of the CTR remodel.

So we set the state dimension n_x to 5.

Here we set the design parameter
lambda to 3- n_x as suggested before.

Then we set the example set x and

the example covariance matrix
P to some realistic values.

Now we create a matrix called Xsig.

This is a matrix with five rows and

This is where I want you to
store the sigma points later.

Now here, I give you a little help for

calculating the square root matrix
of the covariance matrix P.

What you see here are two function calls
which are part of the Eigen library.

It performs a Cholesky decomposition and
provides the result we need.

Feel free to Google this approach,
if you want to know more about it.

This is where you're
supposed to put your code.

I would like you to calculate
all 11 sigma points and

fill the columns of Xsig
with the sigma points.

One thing is important,
when you fill this matrix,

use the same ordering of sigma
points as I showed you in the video,

to make sure the evaluation works.

In the end, the result will be printed,
so you can check if it's realistic.

We received the pointer
Xsig_out as input.

It points to a matrix.

This is how we put our
result into this matrix.

Please don't change anything
outside the student area

to make sure your result
can be evaluated correctly.

Some of the challenges of these
programming assignments are related to

handling rows and columns of
matrices with the Eigen library.

Check link to the Eigen cheat sheet
in the assignment description,

that will help you a lot.