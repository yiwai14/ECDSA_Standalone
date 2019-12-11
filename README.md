# Elliptic Curve Cryptography
Elliptic Curve Cryptography, or ECC, is a powerful approach to cryptography and an alternative method from the well known RSA.

It is an approach used for public key encryption by utilizing the mathematics behind elliptic curves in order to generate security between key pairs.

ECC has been slowly gaining in popularity over the past few years due to it’s ability to provide the same level of security as RSA with a much smaller key size.

The resources available to crack encrypted keys continues to expand, meaning the size of encrypted keys must continue to grow in order to remain secure.

This can prove to be a burden to certain devices, particularly mobile, that do not have as much available computational power.

However, Elliptic Curve Cryptography helps to solve that problem.



# How Does Elliptic Curve Works?
An elliptical curve can simply illustrated as a set of points defined by the following equation:

y2 = x3 + ax + b

Based on the values given to a and b, this will determine the shape of the curve.

Elliptical curve cryptography uses these curves over finite fields to create a secret that only the private key holder is able to unlock.

The larger the key size, the larger the curve, and the harder the problem is to solve.


# ECDSA Authentication
ECDSA stands for Elliptic Curve Digital Signature Algorithm, which offers a variant of the DSA which uses elliptic curve cryptography.

In this repository, the set of parameters used is called **prime256v1**.
