# csc255_class_project
Demonstration of High Availability of Server Cluster

High Availability is a characteristic of a system to improve resiliency of a system.
This project simulates high availablity in server cluster.

Multiple processes are created to represent client, active and standby server.
All communication happen through socket programming.

Our Simulation has the following component-
1. Primary Server     - Actively handle client queries, a new thread is spawned for each client to support multiple client queries

2. Secondary Server   - Standby waits with no-op until Primary process crashes
3. Hearbeat           - Standby sends pulses to the active to check if it is alive.
4. Client             - Creates a connection and communicates with the server.

TODO-
1. Failure Recovery
