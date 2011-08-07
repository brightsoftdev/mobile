//
//  User.h
//  Nellodee
//
//  Created by Ada Hopper on 11/07/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import <Foundation/Foundation.h>

@class SBJsonStreamParser;
@class SBJsonStreamParserAdapter;
@class BasicInfo;
@class About;

@interface MeService : NSObject {
	NSMutableData *responseData;
    
    BasicInfo *basicInfo;
    About *about;

}
- (BOOL) meService;

@property (nonatomic, retain) NSMutableData *responseData;
@property (nonatomic, retain) BasicInfo * basicInfo;
@property (nonatomic, retain) About *about;

@end
