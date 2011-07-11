//
//  User.h
//  Nellodee
//
//  Created by Ada Hopper on 11/07/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import <Foundation/Foundation.h>


@interface User : NSObject {
	NSMutableData *responseData;

}
- (BOOL) meService;

@property (nonatomic, retain) NSMutableData *responseData;

@end
