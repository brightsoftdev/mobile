//
//  Profile.h
//  Nellodee
//
//  Created by Ada Hopper on 17/07/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import <Foundation/Foundation.h>

@class BasicInfo,About;

@interface Profile : NSObject {
    BasicInfo *basicInfo;
    About *about;
	NSMutableArray *categories;
}

@property (nonatomic, retain) BasicInfo * basicInfo;
@property (nonatomic, retain) About *about;
@property (nonatomic, retain) NSMutableArray *categories;

@end
