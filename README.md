RemoteDesktop
=============

An Intranet application for Remote Desktop Support - Client/Server Model


The Application uses a client/Server model. Its a Support Application where the Administrator can Remote Desktop 
to the users in his domain

The above applications defaults to localhost.
A few tweaks in the code can change the IP address.

Basically the two JARs RDPClient and RDPServer are used.

Start the server RDPServer.jar using 
  java jar RDPServer

Start the client RDPClient.jar using
  java jar RDPClient

when the client starts running then only the RDPServer interface is viewed.
