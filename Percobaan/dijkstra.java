// initialize d to infinity, p and Q to empty
d = ( 8 )
p = ()
S = Q = ()

add s to Q
d(s) = 0

while Q is not empty
{
     u = extract-minimum(Q)
     add u to S
     relax-neighbors(u)
}

relax-neighbors(u)
{
     for each vertex v adjacent to u, v not in S
     {
          if d(v) > d(u) + [u,v]    // a shorter distance exists
          {
               d(v) = d(u) + [u,v]
               p(v) = u
               add v to Q
          }
     }
}

extract-minimum(Q)
{
    find the smallest (as defined by d) vertex in Q
    remove it from Q and return it
}