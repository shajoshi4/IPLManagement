# IPLManagement
Application to maintain IPL information like Matches getting organised by IPL, teams for each match and corrosponding players like captain, batsman, baller, fielder, wicketkeepr etc. We are using H2 in memory database to persist this information.

*******************************************************************************************************************************
Please check the following list of basic API to start up with the application:

**Endpoint :** /v1/iplmanagement
**Method :** POST
**Body :** {
  "season": "2023",
  "hostCountry": "India",
  "sponsors": ["Vivo", "Dream11", "Coca-Cola"],
  "matches": [
    {
      "team1": {
        "teamName": "Mumbai Indians",
        "numOfPlayers": 11,
        "players": [
          {
            "name": "Rohit Sharma",
            "age": 34,
            "country": "India",
            "iplDebut": "2008",
            "totalMatchesPlayed": 200,
            "specialization": "Batsman",
            "batsmanInfo": {
              "runsScored": 5000,
              "centuries": 7,
              "halfCenturies": 25,
              "battingAverage": 40.0
            },
            "bowlerInfo": null,
            "captainInfo": {
              "matchesAsCaptain": 100,
              "matchesWonAsCaptain": 70
            },
            "fielderInfo": {
              "catchesTaken": 50,
              "runOuts": 25
            },
            "wicketKeeperInfo": null
          },
          {
            "name": "Jasprit Bumrah",
            "age": 27,
            "country": "India",
            "iplDebut": "2013",
            "totalMatchesPlayed": 100,
            "specialization": "Bowler",
            "batsmanInfo": null,
            "bowlerInfo": {
              "wicketsTaken": 150,
              "fiveWicketHauls": 5,
              "bowlingAverage": 22.0,
              "economyRate": 7.0,
              "hattrickTaken": 2
            },
            "captainInfo": null,
            "fielderInfo": {
              "catchesTaken": 20,
              "runOuts": 10
            },
            "wicketKeeperInfo": null
          }
        ],
        "coach": "Mahela Jayawardene",
        "homeVenue": "Wankhede Stadium",
        "totalMatchesWon": 120,
        "totalMatchesLost": 80,
        "totalMatchesTied": 0,
        "totalMatchesNoResult": 0
      },
      "team2": {
        "teamName": "Chennai Super Kings",
        "numOfPlayers": 11,
        "players": [
          {
            "name": "MS Dhoni",
            "age": 39,
            "country": "India",
            "iplDebut": "2008",
            "totalMatchesPlayed": 190,
            "specialization": "Batsman",
            "batsmanInfo": {
              "runsScored": 4500,
              "centuries": 4,
              "halfCenturies": 30,
              "battingAverage": 35.0
            },
            "bowlerInfo": null,
            "captainInfo": {
              "matchesTossWin": 150,
              "matchesTossLoss": 100
            },
            "fielderInfo": {
              "catchesTaken": 40,
              "runOuts": 20
            },
            "wicketKeeperInfo": {
              "dismissals": 100,
              "catches": 75,
              "stumpings": 25
            }
          },
          {
            "name": "Ravindra Jadeja",
            "age": 32,
            "country": "India",
            "iplDebut": "2008",
            "totalMatchesPlayed": 150,
            "specialization": "All-Rounder",
            "batsmanInfo": {
              "runsScored": 3000,
              "centuries": 1,
              "halfCenturies": 20,
              "battingAverage": 25.0
            },
            "bowlerInfo": {
              "wicketsTaken": 100,
              "fiveWicketHauls": 2,
              "bowlingAverage": 30.0,
              "economyRate": 8.0,
              "hattrickTaken": 0
            },
            "captainInfo": null,
            "fielderInfo": {
              "catchesTaken": 30,
              "runOuts": 15
            },
            "wicketKeeperInfo": null
          }
        ],
        "coach": "Stephen Fleming",
        "homeVenue": "M. A. Chidambaram Stadium",
        "totalMatchesWon": 110,
        "totalMatchesLost": 90,
        "totalMatchesTied": 0,
        "totalMatchesNoResult": 0
      },
      "venue": "Eden Gardens",
      "matchDateTime": "2023-05-20T19:00:00",
      "totalTicketsSold": 50000,
      "totalOvers": 20,
      "winnerTeam": "Mumbai Indians",
      "manOfTheMatch": "Rohit Sharma"
    }
  ]
}

***********************************************************************************************************************************

Endpoint : /v1/iplmanagement/2
Method : GET

***********************************************************************************************************************************






