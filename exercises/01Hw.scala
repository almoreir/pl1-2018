
//Team:(Abdulrahman Moreir && Anis Ben Ghanem)


/**
Homework 01
============
Before doing anything else, register for the Programmiersprachen 1 exercises
by sending an email to Julian Jabs:

julian.jabs@uni-tuebingen.de

Write in the email:
- name
- Matrikelnummer
- Studiengang
- Fachsemester
- name of your GitHub account (register under github.com if you do not have one yet)
- optionally: programming languages you already know

You will receive an invitation to the GitHub Education
platform for Programmiersprachen 1 exercises.
Follow the instructions.

Work in groups of 1 or 2 students.
If you want to work together with another student,
have one of you create a team (you will be asked
to create or join a team by default) and the other
then join that team.

If you have any questions regarding these processes,
contact me by the email address above.

Submit your solution to this exercise until Tuesday, 24.4., 23:59h
via the GitHub repo for your team and for this exercise.
*/

object Hw01 {

/**
Consider the following language of propositional logic formulae:
*/
sealed abstract class Exp
case class True() extends Exp  // constant true
case class False() extends Exp // constant false
case class And(lhs: Exp, rhs: Exp) extends Exp
case class Or(lhs: Exp, rhs: Exp) extends Exp
case class Not(e: Exp) extends Exp
case class Impl(lhs: Exp, rhs: Exp) extends Exp

/**
Tasks:

       1) Implement the missing parts of the interpreter for these formulae
          (the eval function).
          Test the correctness by evaluating the example proposition given
          below and add at least two more examples and test against these.

       2) Add implication as a new kind of expression "Impl" and extend
          the interpreter accordingly. Add at least two examples and test.
*/

def eval(e: Exp) : Boolean = e match {
  case True()    => true
  case False()   => false
  case And(l, r) => (eval(l)&&eval(r))
  case Or(l, r)  => (eval(l)||eval(r))
  case Not(e)    => !eval(e)
  case Impl(l,r) => (!eval(l)||eval(r))
}

val exampleProposition = And(Not(True()), False()) // should evaluate to false
eval (exampleProposition)
val x1 = Impl(True(),False())
eval(x1)
val x2 = Or(False(),Impl(False(), And (True(),Or(True(),False()))))
eval(x2)
val x3 = Impl(Not(False()),Or(True(),And(True(),False())))
eval(x3)
val x4 = Or(True(),And(Not(False()),Or(True(),False())))
eval(x4)

}
