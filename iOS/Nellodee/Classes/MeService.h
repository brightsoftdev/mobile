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

@interface MeService : NSObject {
	NSMutableData *responseData;

}
- (BOOL) meService;

@property (nonatomic, retain) NSMutableData *responseData;

@end
