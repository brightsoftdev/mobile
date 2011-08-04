//
//  NellodeeApp.m
//  Nellodee
//
//  Created by Ada Hopper on 26/06/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import "NellodeeApp.h"
#import "BasicInfo.h"
#import "MeService.h"

@implementation NellodeeApp

@synthesize sakaiURL, cookies;
@synthesize basicInfo,aboutMe;


#pragma mark Singleton Methods
+ (id)sharedNellodeeData {
    static NellodeeApp *sharedNell;

    @synchronized(self) {
        if(!sharedNell)
            sharedNell = [[super allocWithZone:NULL] init];
    }
    return sharedNell;
}

+ (id)allocWithZone:(NSZone *)zone {
    return [[self sharedNellodeeData] retain];
}

- (id)copyWithZone:(NSZone *)zone {
    return self;
}

- (id)retain {
    return self;
}

- (unsigned)retainCount {
    return UINT_MAX; //denotes an object that cannot be released
}

- (void)release {
    // never release
}

- (id)autorelease {
    return self;
}

- (id)init {
    if ((self = [super init])) {
        //Get stored data
        NSUserDefaults *defaults = [NSUserDefaults standardUserDefaults];
        NSString *url = [defaults objectForKey:@"url"];
        NSLog(@" URL: %@",url);
        if(url){
            sakaiURL = [[NSString alloc] initWithString:url];
        }
    }
    return self;
}


- (void)dealloc {
    // Should never be called, but just here for clarity really.
    [sakaiURL release];
    [cookies release];
    [super dealloc];
}

@end
