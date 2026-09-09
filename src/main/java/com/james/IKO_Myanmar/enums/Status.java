package com.james.IKO_Myanmar.enums;

public enum Status {
    // User
    Active,
    Inactive,
    Deactivated,

    // Blog
    Published,
    Draft,
    Removed,

    // Class, Training, Tournament, Match
    Started,
    Upcoming,
    Ongoing,
    Ended,
    Cancelled,
    Discontinued,

    // Dojo
    Open,
    Closed,
    Repairing,
    Defunct,

    // Student
    Learning,
    Graduated,
    OnLeave,
    Quit,
    Banned,

    // Trainer
    InService,
    Retired,
    Resigned,
    Dismissed
}