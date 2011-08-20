//
//  BasicInfoWS.h
//  Nellodee
//
//  Created by Ada Hopper on 20/08/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import <Foundation/Foundation.h>

@class SBJsonStreamParser;
@class SBJsonStreamParserAdapter;
@class BasicInfo;

@interface BasicInfoWS : NSObject {
	NSMutableData *responseData;
    BasicInfo *basicInfo;
}

- (BOOL) meService;

@property (nonatomic, retain) NSMutableData *responseData;
@property (nonatomic, retain) BasicInfo * basicInfo;

@end
