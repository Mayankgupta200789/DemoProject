package companies.wayfair;

public class Wayfair {

    public static void main(String[] args) {


        // We have a photo sharing app where users can upload photos and share a link to other users
        // And we have a scalable server pool to distribute photo workloads by user name
        // alphabetically, from a to each of the server in a pool
        // Assuming the pool can scale automatically if more user signing up, whats the problem
        // with the design
        // Ans : Consistent hashing or meta-data of photo workload or combinatino of these all

        // A single process program is creating a single thread for every new video stream running on single machine.
        // A bug is found to cause the single process to crash when processing more than 10 video streams at the same
        // time. During livesite, we don't have time to push a bug fix, Assuming you're on the on-call SRE, what immediate
        // actions would you take to mitigate the issue
        // Ans : I could limit heap or thread count utilized by program in the deployment config or if there is a side car
        // container, I could control the new video stream count
        //we can stop allocating new requests in load balancer to a service and spin up a new pod with updated config.
        // If we are able to identify the bug and if we are maintaining the list of history images, we
        // can redeploy the previous image and restart the server
        //  Backed by a toggle,

        // I have an internet connected vending machine system. Each vending machine reports its stocking information at
        // at 1AM every day to a server machine, so that we can decide if we should re-stock them.
        // What's the problem of this design
        // Ans: IP doesn't guarantee anyting, its best effort only. Network outage, downtime during reporting -instead
        // of look-ahead schedule based on user demand patterns w.r.t time and days, server machine can be down, worst
        // ase scenario - bit flip (very very rare) causing AM to change PM. Man in the middle attack . Power failure
        // in the building. Downtime between reporting and time taken to restock.

        // I have a mobile app to analyze a completed Go game, to provide suggestions to improve players' Go skills. There
        // are two implementation options.
        // 1) Analyze the Go game locally in the mobile app
        // 2) Send the game to a server and get back the analysis report to the mobile client.
        // What's advantages and disadvantage of each approach?
        // Ans: It depends on how the implementation is done - Go game has way more branches. If you send to server
        //we have more time to give in depth analysis on comparison with other players or rank the success rate based on
        // progress rate or game play style. If we have a huge data - we could have some batch process done on it and build
        // a complex recommendation system sort of. If you do locally - it needs to update the lcoal data ( say heruistic ones )
        // may be mobile phone has limite cpy/ram. We don't need 27 X 7 internet connection for local analysis. If we send
        // server based on user progress we might suggest ads


        // We have a photo sharing app where users can upload photos and share a link to other users. What kind
        // of attributes would you consider to project and determine the total capacity of the storage we need.
        // Our user base -> we can have mobile users (1080p), laptop users ( 1440p) desktop users (4k, 8k) depending
        // on house hold size, demographic ratio of people we cold estimate the average photo size
        // Once we upload we are assuming no sort of image processing -> we just read data from our system ->
        // It could 100:1 (read : write) ratio
        // OF course we will be doing image compression to save storage. We also need to replicate this data to have
        // better read latency and awesome bandwith to support transfer rates.
        // We need to cache stuff may our own CDN or use third party ones.






    }


}
