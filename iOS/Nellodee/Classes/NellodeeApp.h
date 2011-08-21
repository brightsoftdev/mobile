//
//  NellodeeApp.h
//  Nellodee
//
//  Created by Ada Hopper on 26/06/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import <Foundation/Foundation.h>
@class BasicInfo;
@class About;
@class Profile;

@interface NellodeeApp : NSObject {
	NSString *sakaiURL;
	NSArray *cookies;
    
	Profile *userProfile;
    BasicInfo *basicInfo;
    About *aboutMe;
}

//Nellodee config properties
@property (nonatomic, retain) NSString *sakaiURL;

//Shared info
@property (nonatomic, retain) NSArray *cookies;

//Data downloaded
@property (nonatomic, retain) BasicInfo *basicInfo;
@property (nonatomic, retain) About *aboutMe;
@property (nonatomic, retain) Profile *userProfile;

+ (id)sharedNellodeeData;

@end
